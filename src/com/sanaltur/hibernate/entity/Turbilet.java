package com.sanaltur.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="turbilet")
public class Turbilet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bilet_id")
	private int biletId;
	
	@Column(name="musteri_ad")
	private String musteriAd;
	
	@Column(name="musteri_soyad")
	private String musteriSoyad;
	
	@Column(name="otobus_no")
	private int otobusNo;
	
	@Column(name="musteri_no")
	private int musteriNo;

	public Turbilet() {
		
	}

	public Turbilet(String musteriAd, String musteriSoyad, int otobusNo, int musteriNo) {
		this.musteriAd = musteriAd;
		this.musteriSoyad = musteriSoyad;
		this.otobusNo = otobusNo;
		this.musteriNo = musteriNo;
	}

	public int getBiletId() {
		return biletId;
	}

	public void setBiletId(int biletId) {
		this.biletId = biletId;
	}

	public String getMusteriAd() {
		return musteriAd;
	}

	public void setMusteriAd(String musteriAd) {
		this.musteriAd = musteriAd;
	}

	public String getMusteriSoyad() {
		return musteriSoyad;
	}

	public void setMusteriSoyad(String musteriSoyad) {
		this.musteriSoyad = musteriSoyad;
	}

	public int getOtobusNo() {
		return otobusNo;
	}

	public void setOtobusNo(int otobusNo) {
		this.otobusNo = otobusNo;
	}

	public int getMusteriNo() {
		return musteriNo;
	}

	public void setMusteriNo(int musteriNo) {
		this.musteriNo = musteriNo;
	}

	@Override
	public String toString() {
		return "Turbilet [biletId=" + biletId + ", musteriAd=" + musteriAd + ", musteriSoyad=" + musteriSoyad
				+ ", otobusNo=" + otobusNo + ", musteriNo=" + musteriNo + "]";
	}
	
	
	
}
