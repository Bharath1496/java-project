package com.Inmemory.Flowchart.Entity;

public class Node {
	
	 private String id;  // Unique identifier (e.g., A, B, C)

	 public Node(String id) {
	      this.id = id;
	 }

	 public Node() {} // Default constructor for deserialization

	 public String getId() {
	     return id;
	 }

	 public void setId(String id) {
	     this.id = id;
	 }

	 @Override
	 public String toString() {
	     return "Node{id='" + id + "'}";
	  }
	
}
