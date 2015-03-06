package org.gen;

// Generated Mar 6, 2015 3:28:00 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Store generated by hbm2java
 */
public class Store implements java.io.Serializable {

	private byte storeId;
	private Address address;
	private Staff staff;
	private Date lastUpdate;
	private Set customers = new HashSet(0);
	private Set staffs = new HashSet(0);
	private Set inventories = new HashSet(0);
	private Set customers_1 = new HashSet(0);
	private Set inventories_1 = new HashSet(0);
	private Set staffs_1 = new HashSet(0);

	public Store() {
	}

	public Store(byte storeId, Address address, Staff staff, Date lastUpdate) {
		this.storeId = storeId;
		this.address = address;
		this.staff = staff;
		this.lastUpdate = lastUpdate;
	}

	public Store(byte storeId, Address address, Staff staff, Date lastUpdate,
			Set customers, Set staffs, Set inventories, Set customers_1,
			Set inventories_1, Set staffs_1) {
		this.storeId = storeId;
		this.address = address;
		this.staff = staff;
		this.lastUpdate = lastUpdate;
		this.customers = customers;
		this.staffs = staffs;
		this.inventories = inventories;
		this.customers_1 = customers_1;
		this.inventories_1 = inventories_1;
		this.staffs_1 = staffs_1;
	}

	public byte getStoreId() {
		return this.storeId;
	}

	public void setStoreId(byte storeId) {
		this.storeId = storeId;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Set getCustomers() {
		return this.customers;
	}

	public void setCustomers(Set customers) {
		this.customers = customers;
	}

	public Set getStaffs() {
		return this.staffs;
	}

	public void setStaffs(Set staffs) {
		this.staffs = staffs;
	}

	public Set getInventories() {
		return this.inventories;
	}

	public void setInventories(Set inventories) {
		this.inventories = inventories;
	}

	public Set getCustomers_1() {
		return this.customers_1;
	}

	public void setCustomers_1(Set customers_1) {
		this.customers_1 = customers_1;
	}

	public Set getInventories_1() {
		return this.inventories_1;
	}

	public void setInventories_1(Set inventories_1) {
		this.inventories_1 = inventories_1;
	}

	public Set getStaffs_1() {
		return this.staffs_1;
	}

	public void setStaffs_1(Set staffs_1) {
		this.staffs_1 = staffs_1;
	}

}
