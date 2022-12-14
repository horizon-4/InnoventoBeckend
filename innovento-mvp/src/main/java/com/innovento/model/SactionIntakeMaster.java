// Generated with g9.

package com.innovento.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity(name="saction_approved_intake_master")
public class SactionIntakeMaster implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(unique=true, nullable=false, precision=10)
    private long id;
    @Column(name="program_id", precision=10) 
    private long programId;
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="2020_21_count", precision=10)
    private long _2020_21_Count;
    @Column(name="2019_20_count", precision=10)
    private long _2019_20_Count;
    @Column(name="2018_19_count", precision=10)
    private long _2018_19_Count;
    @Column(name="2017_18_count", precision=10)
    private long _2017_18_Count;
    @Column(name="2016_17_count", precision=10)
    private long _2016_17_Count;
    @Column(name="2015_16_count", precision=10)
    private long _2015_16_Count;

    /** Default constructor. */
    public SactionIntakeMaster() {
        super();
    }

    /**
     * Access method for programId.
     *
     * @return the current value of programId
     */
   

    /**
     * Access method for _202021Count.
     *
     * @return the current value of _202021Count
     */
    public long get_2020_21_Count() {
        return _2020_21_Count;
    }

    public long getProgramId() {
		return programId;
	}

	public void setProgramId(long programId) {
		this.programId = programId;
	}

	/**
     * Setter method for _202021Count.
     *
     * @param a_202021Count the new value for _202021Count
     */
    public void set_2020_21_Count(long a_202021Count) {
    	_2020_21_Count = a_202021Count;
    }

    /**
     * Access method for _201920Count.
     *
     * @return the current value of _201920Count
     */
    public long get_2019_20_Count() {
        return _2019_20_Count;
    }

    /**
     * Setter method for _201920Count.
     *
     * @param a_201920Count the new value for _201920Count
     */
    public void set_2019_20_Count(long a_201920Count) {
        _2019_20_Count = a_201920Count;
    }

    /**
     * Access method for _201819Count.
     *
     * @return the current value of _201819Count
     */
    public long get_2018_19_Count() {
        return _2018_19_Count;
    }

    /**
     * Setter method for _201819Count.
     *
     * @param a_201819Count the new value for _201819Count
     */
    public void set_2018_19_Count(long a_201819Count) {
        _2018_19_Count = a_201819Count;
    }

    /**
     * Access method for _201718Count.
     *
     * @return the current value of _201718Count
     */
    public long get_2017_18_Count() {
        return _2017_18_Count;
    }

    /**
     * Setter method for _201718Count.
     *
     * @param a_201718Count the new value for _201718Count
     */
    public void set_2017_18_Count(long a_201718Count) {
        _2017_18_Count = a_201718Count;
    }

    /**
     * Access method for _201617Count.
     *
     * @return the current value of _201617Count
     */
    public long get_2016_17_Count() {
        return _2016_17_Count;
    }

    /**
     * Setter method for _201617Count.
     *
     * @param a_201617Count the new value for _201617Count
     */
    public void set_2016_17_Count(long a_201617Count) {
        _2016_17_Count = a_201617Count;
    }

    /**
     * Access method for _201516Count.
     *
     * @return the current value of _201516Count
     */
    public long get_2015_16_Count() {
        return _2015_16_Count;
    }

    /**
     * Setter method for _201516Count.
     *
     * @param a_201516Count the new value for _201516Count
     */
    public void set_2015_16_Count(long a_201516Count) {
        _2015_16_Count = a_201516Count;
    }

}
