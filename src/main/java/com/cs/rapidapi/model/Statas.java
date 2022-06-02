package com.cs.rapidapi.model;

import com.cs.rapidapi.bean.Data;

public class Statas {
	 private boolean error;
	 private float statusCode;
	 private String message;
	 Data DataObject;


	 // Getter Methods 

	 public boolean getError() {
	  return error;
	 }

	 public float getStatusCode() {
	  return statusCode;
	 }

	 public String getMessage() {
	  return message;
	 }

	 public Data getData() {
	  return DataObject;
	 }

	 // Setter Methods 

	 public void setError(boolean error) {
	  this.error = error;
	 }

	 public void setStatusCode(float statusCode) {
	  this.statusCode = statusCode;
	 }

	 public void setMessage(String message) {
	  this.message = message;
	 }

	 public void setData(Data dataObject) {
	  this.DataObject = dataObject;
	 }
	}
	
