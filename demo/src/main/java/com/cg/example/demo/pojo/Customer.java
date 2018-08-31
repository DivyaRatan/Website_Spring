package com.cg.example.demo.pojo;

import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@XmlRootElement
@Component

public class Customer{
	
		@Id
		private ObjectId _Id;
	
		private int customerId;
		
		private String CustName;
		

		public Customer() {
			
		}
		

		public Customer(int customerId, String custName) {
			super();
			this.customerId = customerId;
			CustName = custName;
		}


		public int getCustomerId() {
			return customerId;
		}

		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}

		public String getCustName() {
			return CustName;
		}

		public void setCustName(String custName) {
			CustName = custName;
		}

		@Override
		public String toString() {
			return "Customer [CustomerId=" + customerId + ", CustName=" + CustName + "]";
		}
		
		
		
		
}
