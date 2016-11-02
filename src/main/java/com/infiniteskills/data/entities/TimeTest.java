package com.infiniteskills.data.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TIME_TEST")
public class TimeTest {

	@Id
	@GeneratedValue
	@Column(name = "TIME_TEST_ID")
	private Long timeTestId;

	@Column(name = "DATETIME_COLUMN")
	private Date dateTimeColumn;

	@Column(name = "TIMESTAMP_COLUMN")
	private Date timeStampColumn;

	@Column(name = "DATE_COLUMN")
	private Date dateColumn;

	@Column(name = "TIME_COLUMN")
	private Date timeColumn;

	@Column(name = "SQL_DATETIME_COLUMN")
	private java.sql.Timestamp sqlDatetimeColumn;

	@Column(name = "SQL_TIMESTAMP_COLUMN")
	private java.sql.Timestamp sqlTimestampColumn;

	@Column(name = "SQL_DATE_COLUMN")
	private java.sql.Date sqlDateColumn;

	@Column(name = "SQL_TIME_COLUMN")
	private java.sql.Time sqlTimeColumn;

	public TimeTest() {
		// TODO Auto-generated constructor stub
	}

}
