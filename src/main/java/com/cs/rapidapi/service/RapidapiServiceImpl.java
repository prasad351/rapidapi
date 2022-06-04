package com.cs.rapidapi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cs.rapidapi.bean.Covid19Stats;
import com.cs.rapidapi.bean.Statas;
import com.cs.rapidapi.common.Constants;
import com.cs.rapidapi.common.RapidUtils;
import com.cs.rapidapi.controller.RapidAPIController;
import com.cs.rapidapi.entity.Covid19Details;
import com.cs.rapidapi.repo.Covid19DetailsRepository;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

@Service
public class RapidapiServiceImpl implements RapidapiService {
	Logger logger = LoggerFactory.getLogger(RapidapiServiceImpl.class);

	@Value("${CS.STATISTICS.URL}")
	private String url;
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	Covid19DetailsRepository covid19DetailsRepository;

	@Autowired
	RapidUtils rapidUtils;

	public List<Covid19Stats> getCovid19Stats() {

		Statas covid19Stats = restTemplate
				.exchange(url + Constants.STATS, HttpMethod.GET, rapidUtils.getHeaders(), Statas.class).getBody();

		if (covid19Stats.getData() != null) {
			covid19DetailsRepository.saveAll(convertToEntitiyBean(covid19Stats.getData().getCovid19Stats()));
		}

		return covid19Stats.getData().getCovid19Stats();

	}

	public List<Covid19Stats> getCovid19Stats(String country) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("country", country);

		Statas covid19Stats = restTemplate
				.exchange(url + Constants.STATS, HttpMethod.GET, rapidUtils.getHeaders(), Statas.class, params)
				.getBody();

		return covid19Stats.getData().getCovid19Stats();
	}

	@Override
	public List<Covid19Stats> getCovid19Stats(Integer pageNo, Integer pageSize, String sortBy) {

		Pageable paging;
		if (StringUtil.isNullOrEmpty(sortBy)) {
			paging = PageRequest.of(pageNo, pageSize);

		} else {
			paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		}

		Page<Covid19Details> pagedResult = covid19DetailsRepository.findAll(paging);
		if (pagedResult.hasContent()) {
			return convertBean(pagedResult.getContent());
		} else {
			return new ArrayList<Covid19Stats>();
		}

	}

	private List<Covid19Stats> convertBean(List<Covid19Details> content) {
		List<Covid19Stats> covid19Details = content.stream().map(value -> toMap(new Covid19Stats(), value))
				.collect(Collectors.toList());
		return covid19Details;
	}

	private List<Covid19Details> convertToEntitiyBean(List<Covid19Stats> content) {
		List<Covid19Details> covid19Details = content.stream().map(value -> toEntityMap(new Covid19Details(), value))
				.collect(Collectors.toList());
		return covid19Details;
	}

	private Covid19Details toEntityMap(Covid19Details covid19Details, Covid19Stats value) {
		BeanUtils.copyProperties(covid19Details, value);
		return covid19Details;
	}

	public Covid19Stats toMap(Covid19Stats covid19Stats, Covid19Details value) {
		BeanUtils.copyProperties(covid19Stats, value);
		return covid19Stats;
	}

}
