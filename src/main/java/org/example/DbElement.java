package org.example;

import java.sql.Timestamp;
import java.util.Date;

public class DbElement implements Comparable<DbElement>{

    private Long idObj;
    private Long rev;
    private Date dataInizioAttivita;
    private Date datafineAttivita;

    public Long getIdObj() {
        return idObj;
    }

    public void setIdObj(Long idObj) {
        this.idObj = idObj;
    }

    public Long getRev() {
        return rev;
    }

    public void setRev(Long rev) {
        this.rev = rev;
    }

    public Date getDataInizioAttivita() {
        return dataInizioAttivita;
    }

    public void setDataInizioAttivita(Date dataInizioAttivita) {
        this.dataInizioAttivita = dataInizioAttivita;
    }

    public Date getDatafineAttivita() {
        return datafineAttivita;
    }

    public void setDatafineAttivita(Date datafineAttivita) {
        this.datafineAttivita = datafineAttivita;
    }

    @Override
    public int compareTo(DbElement o) {
        return rev.compareTo(o.getRev());
    }
}
