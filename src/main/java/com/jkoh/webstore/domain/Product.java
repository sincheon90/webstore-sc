package com.jkoh.webstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import com.jkoh.webstore.format.ValueFormat;

@XmlRootElement
public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2514887072695290970L;
	private String productId;
	private String name;
	private BigDecimal unitPrice;
	private String unitPriceStr;
	
	private String description;
	private String manufacturer;
	private String category;
	private long unitsInStock;
	private String unitsInStockStr;
	private long unitsInOrder;
	private boolean discontinued;
	private String condition;
	
	@JsonIgnore
	private MultipartFile productImage;
//	private MultipartFile productManual;

	public Product() {
		super();
	}

	public Product(String productId, String name, BigDecimal unitPrice) {

		this.productId = productId;
		this.name = name;
		this.setUnitPrice(unitPrice);
	}

//	public MultipartFile getProductManual() {
//		return productManual;
//	}
//
//	public void setProductManual(MultipartFile productManual) {
//		this.productManual = productManual;
//	}
	
	@XmlTransient
	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
		if (unitPrice == null)
			unitPrice = new BigDecimal(0);
		DecimalFormat df = new DecimalFormat("#,###");
		this.unitPriceStr = df.format(unitPrice);		
	}

	public String getUnitPriceStr() {
		return unitPriceStr;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
		this.unitsInStockStr = ValueFormat.format(unitsInStock, ValueFormat.COMMAS);
	}

	public String getUnitsInStockStr() {
		return unitsInStockStr;
	}

	public long getUnitsInOrder() {
		return unitsInOrder;
	}

	public void setUnitsInOrder(long unitsInOrder) {
		this.unitsInOrder = unitsInOrder;
	}

	public boolean isDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		return result;
	}
	

}
