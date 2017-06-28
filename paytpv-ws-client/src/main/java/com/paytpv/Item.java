//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.05.24 a las 02:20:03 PM BST 
//


package com.paytpv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PAYTPV_ERROR_ID" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *         &lt;element name="PAYTPV_OPERATION_ID" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="PAYTPV_OPERATION_TIMESTAMP" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="PAYTPV_OPERATION_REFERENCE" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PAYTPV_OPERATION_OPERATION" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *         &lt;element name="PAYTPV_OPERATION_OPERATIONNAME" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PAYTPV_OPERATION_STATE" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *         &lt;element name="PAYTPV_OPERATION_STATENAME" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PAYTPV_OPERATION_TERMINAL" type="{http://www.w3.org/2001/XMLSchema}short"/&gt;
 *         &lt;element name="PAYTPV_OPERATION_TERMINALNAME" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PAYTPV_OPERATION_PAN" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PAYTPV_OPERATION_USER" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PAYTPV_OPERATION_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}short"/&gt;
 *         &lt;element name="PAYTPV_OPERATION_CURRENCY" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PAYTPV_OPERATION_AMOUNTDISPLAY" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PAYTPV_OPERATION_ERRORID" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *         &lt;element name="PAYTPV_OPERATION_ERRORDESC" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PAYTPV_OPERATION_FEEEURO" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *         &lt;element name="PAYTPV_OPERATION_FEEPERCENT" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *         &lt;element name="PAYTPV_OPERATION_IP" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PAYTPV_OPERATION_CARDBRAND" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PAYTPV_OPERATION_BICCODE" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PAYTPV_OPERATION_SCORING" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PAYTPV_OPERATION_AUTHCODE" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "paytpverrorid",
    "paytpvoperationid",
    "paytpvoperationtimestamp",
    "paytpvoperationreference",
    "paytpvoperationoperation",
    "paytpvoperationoperationname",
    "paytpvoperationstate",
    "paytpvoperationstatename",
    "paytpvoperationterminal",
    "paytpvoperationterminalname",
    "paytpvoperationpan",
    "paytpvoperationuser",
    "paytpvoperationamount",
    "paytpvoperationcurrency",
    "paytpvoperationamountdisplay",
    "paytpvoperationerrorid",
    "paytpvoperationerrordesc",
    "paytpvoperationfeeeuro",
    "paytpvoperationfeepercent",
    "paytpvoperationip",
    "paytpvoperationcardbrand",
    "paytpvoperationbiccode",
    "paytpvoperationscoring",
    "paytpvoperationauthcode"
})
@XmlRootElement(name = "item")
public class Item {

    @XmlElement(name = "PAYTPV_ERROR_ID")
    protected byte paytpverrorid;
    @XmlElement(name = "PAYTPV_OPERATION_ID")
    protected int paytpvoperationid;
    @XmlElement(name = "PAYTPV_OPERATION_TIMESTAMP")
    protected long paytpvoperationtimestamp;
    @XmlElement(name = "PAYTPV_OPERATION_REFERENCE", required = true)
    protected String paytpvoperationreference;
    @XmlElement(name = "PAYTPV_OPERATION_OPERATION")
    protected byte paytpvoperationoperation;
    @XmlElement(name = "PAYTPV_OPERATION_OPERATIONNAME", required = true)
    protected String paytpvoperationoperationname;
    @XmlElement(name = "PAYTPV_OPERATION_STATE")
    protected byte paytpvoperationstate;
    @XmlElement(name = "PAYTPV_OPERATION_STATENAME", required = true)
    protected String paytpvoperationstatename;
    @XmlElement(name = "PAYTPV_OPERATION_TERMINAL")
    protected short paytpvoperationterminal;
    @XmlElement(name = "PAYTPV_OPERATION_TERMINALNAME", required = true)
    protected String paytpvoperationterminalname;
    @XmlElement(name = "PAYTPV_OPERATION_PAN", required = true)
    protected String paytpvoperationpan;
    @XmlElement(name = "PAYTPV_OPERATION_USER", required = true)
    protected String paytpvoperationuser;
    @XmlElement(name = "PAYTPV_OPERATION_AMOUNT")
    protected short paytpvoperationamount;
    @XmlElement(name = "PAYTPV_OPERATION_CURRENCY", required = true)
    protected String paytpvoperationcurrency;
    @XmlElement(name = "PAYTPV_OPERATION_AMOUNTDISPLAY", required = true)
    protected String paytpvoperationamountdisplay;
    @XmlElement(name = "PAYTPV_OPERATION_ERRORID")
    protected byte paytpvoperationerrorid;
    @XmlElement(name = "PAYTPV_OPERATION_ERRORDESC", required = true)
    protected String paytpvoperationerrordesc;
    @XmlElement(name = "PAYTPV_OPERATION_FEEEURO")
    protected byte paytpvoperationfeeeuro;
    @XmlElement(name = "PAYTPV_OPERATION_FEEPERCENT")
    protected byte paytpvoperationfeepercent;
    @XmlElement(name = "PAYTPV_OPERATION_IP", required = true)
    protected String paytpvoperationip;
    @XmlElement(name = "PAYTPV_OPERATION_CARDBRAND", required = true)
    protected String paytpvoperationcardbrand;
    @XmlElement(name = "PAYTPV_OPERATION_BICCODE", required = true)
    protected String paytpvoperationbiccode;
    @XmlElement(name = "PAYTPV_OPERATION_SCORING", required = true)
    protected String paytpvoperationscoring;
    @XmlElement(name = "PAYTPV_OPERATION_AUTHCODE", required = true)
    protected String paytpvoperationauthcode;

    /**
     * Obtiene el valor de la propiedad paytpverrorid.
     * 
     */
    public byte getPAYTPVERRORID() {
        return paytpverrorid;
    }

    /**
     * Define el valor de la propiedad paytpverrorid.
     * 
     */
    public void setPAYTPVERRORID(byte value) {
        this.paytpverrorid = value;
    }

    /**
     * Obtiene el valor de la propiedad paytpvoperationid.
     * 
     */
    public int getPAYTPVOPERATIONID() {
        return paytpvoperationid;
    }

    /**
     * Define el valor de la propiedad paytpvoperationid.
     * 
     */
    public void setPAYTPVOPERATIONID(int value) {
        this.paytpvoperationid = value;
    }

    /**
     * Obtiene el valor de la propiedad paytpvoperationtimestamp.
     * 
     */
    public long getPAYTPVOPERATIONTIMESTAMP() {
        return paytpvoperationtimestamp;
    }

    /**
     * Define el valor de la propiedad paytpvoperationtimestamp.
     * 
     */
    public void setPAYTPVOPERATIONTIMESTAMP(long value) {
        this.paytpvoperationtimestamp = value;
    }

    /**
     * Obtiene el valor de la propiedad paytpvoperationreference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYTPVOPERATIONREFERENCE() {
        return paytpvoperationreference;
    }

    /**
     * Define el valor de la propiedad paytpvoperationreference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYTPVOPERATIONREFERENCE(String value) {
        this.paytpvoperationreference = value;
    }

    /**
     * Obtiene el valor de la propiedad paytpvoperationoperation.
     * 
     */
    public byte getPAYTPVOPERATIONOPERATION() {
        return paytpvoperationoperation;
    }

    /**
     * Define el valor de la propiedad paytpvoperationoperation.
     * 
     */
    public void setPAYTPVOPERATIONOPERATION(byte value) {
        this.paytpvoperationoperation = value;
    }

    /**
     * Obtiene el valor de la propiedad paytpvoperationoperationname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYTPVOPERATIONOPERATIONNAME() {
        return paytpvoperationoperationname;
    }

    /**
     * Define el valor de la propiedad paytpvoperationoperationname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYTPVOPERATIONOPERATIONNAME(String value) {
        this.paytpvoperationoperationname = value;
    }

    /**
     * Obtiene el valor de la propiedad paytpvoperationstate.
     * 
     */
    public byte getPAYTPVOPERATIONSTATE() {
        return paytpvoperationstate;
    }

    /**
     * Define el valor de la propiedad paytpvoperationstate.
     * 
     */
    public void setPAYTPVOPERATIONSTATE(byte value) {
        this.paytpvoperationstate = value;
    }

    /**
     * Obtiene el valor de la propiedad paytpvoperationstatename.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYTPVOPERATIONSTATENAME() {
        return paytpvoperationstatename;
    }

    /**
     * Define el valor de la propiedad paytpvoperationstatename.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYTPVOPERATIONSTATENAME(String value) {
        this.paytpvoperationstatename = value;
    }

    /**
     * Obtiene el valor de la propiedad paytpvoperationterminal.
     * 
     */
    public short getPAYTPVOPERATIONTERMINAL() {
        return paytpvoperationterminal;
    }

    /**
     * Define el valor de la propiedad paytpvoperationterminal.
     * 
     */
    public void setPAYTPVOPERATIONTERMINAL(short value) {
        this.paytpvoperationterminal = value;
    }

    /**
     * Obtiene el valor de la propiedad paytpvoperationterminalname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYTPVOPERATIONTERMINALNAME() {
        return paytpvoperationterminalname;
    }

    /**
     * Define el valor de la propiedad paytpvoperationterminalname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYTPVOPERATIONTERMINALNAME(String value) {
        this.paytpvoperationterminalname = value;
    }

    /**
     * Obtiene el valor de la propiedad paytpvoperationpan.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYTPVOPERATIONPAN() {
        return paytpvoperationpan;
    }

    /**
     * Define el valor de la propiedad paytpvoperationpan.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYTPVOPERATIONPAN(String value) {
        this.paytpvoperationpan = value;
    }

    /**
     * Obtiene el valor de la propiedad paytpvoperationuser.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYTPVOPERATIONUSER() {
        return paytpvoperationuser;
    }

    /**
     * Define el valor de la propiedad paytpvoperationuser.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYTPVOPERATIONUSER(String value) {
        this.paytpvoperationuser = value;
    }

    /**
     * Obtiene el valor de la propiedad paytpvoperationamount.
     * 
     */
    public short getPAYTPVOPERATIONAMOUNT() {
        return paytpvoperationamount;
    }

    /**
     * Define el valor de la propiedad paytpvoperationamount.
     * 
     */
    public void setPAYTPVOPERATIONAMOUNT(short value) {
        this.paytpvoperationamount = value;
    }

    /**
     * Obtiene el valor de la propiedad paytpvoperationcurrency.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYTPVOPERATIONCURRENCY() {
        return paytpvoperationcurrency;
    }

    /**
     * Define el valor de la propiedad paytpvoperationcurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYTPVOPERATIONCURRENCY(String value) {
        this.paytpvoperationcurrency = value;
    }

    /**
     * Obtiene el valor de la propiedad paytpvoperationamountdisplay.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYTPVOPERATIONAMOUNTDISPLAY() {
        return paytpvoperationamountdisplay;
    }

    /**
     * Define el valor de la propiedad paytpvoperationamountdisplay.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYTPVOPERATIONAMOUNTDISPLAY(String value) {
        this.paytpvoperationamountdisplay = value;
    }

    /**
     * Obtiene el valor de la propiedad paytpvoperationerrorid.
     * 
     */
    public byte getPAYTPVOPERATIONERRORID() {
        return paytpvoperationerrorid;
    }

    /**
     * Define el valor de la propiedad paytpvoperationerrorid.
     * 
     */
    public void setPAYTPVOPERATIONERRORID(byte value) {
        this.paytpvoperationerrorid = value;
    }

    /**
     * Obtiene el valor de la propiedad paytpvoperationerrordesc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYTPVOPERATIONERRORDESC() {
        return paytpvoperationerrordesc;
    }

    /**
     * Define el valor de la propiedad paytpvoperationerrordesc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYTPVOPERATIONERRORDESC(String value) {
        this.paytpvoperationerrordesc = value;
    }

    /**
     * Obtiene el valor de la propiedad paytpvoperationfeeeuro.
     * 
     */
    public byte getPAYTPVOPERATIONFEEEURO() {
        return paytpvoperationfeeeuro;
    }

    /**
     * Define el valor de la propiedad paytpvoperationfeeeuro.
     * 
     */
    public void setPAYTPVOPERATIONFEEEURO(byte value) {
        this.paytpvoperationfeeeuro = value;
    }

    /**
     * Obtiene el valor de la propiedad paytpvoperationfeepercent.
     * 
     */
    public byte getPAYTPVOPERATIONFEEPERCENT() {
        return paytpvoperationfeepercent;
    }

    /**
     * Define el valor de la propiedad paytpvoperationfeepercent.
     * 
     */
    public void setPAYTPVOPERATIONFEEPERCENT(byte value) {
        this.paytpvoperationfeepercent = value;
    }

    /**
     * Obtiene el valor de la propiedad paytpvoperationip.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYTPVOPERATIONIP() {
        return paytpvoperationip;
    }

    /**
     * Define el valor de la propiedad paytpvoperationip.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYTPVOPERATIONIP(String value) {
        this.paytpvoperationip = value;
    }

    /**
     * Obtiene el valor de la propiedad paytpvoperationcardbrand.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYTPVOPERATIONCARDBRAND() {
        return paytpvoperationcardbrand;
    }

    /**
     * Define el valor de la propiedad paytpvoperationcardbrand.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYTPVOPERATIONCARDBRAND(String value) {
        this.paytpvoperationcardbrand = value;
    }

    /**
     * Obtiene el valor de la propiedad paytpvoperationbiccode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYTPVOPERATIONBICCODE() {
        return paytpvoperationbiccode;
    }

    /**
     * Define el valor de la propiedad paytpvoperationbiccode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYTPVOPERATIONBICCODE(String value) {
        this.paytpvoperationbiccode = value;
    }

    /**
     * Obtiene el valor de la propiedad paytpvoperationscoring.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYTPVOPERATIONSCORING() {
        return paytpvoperationscoring;
    }

    /**
     * Define el valor de la propiedad paytpvoperationscoring.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYTPVOPERATIONSCORING(String value) {
        this.paytpvoperationscoring = value;
    }

    /**
     * Obtiene el valor de la propiedad paytpvoperationauthcode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYTPVOPERATIONAUTHCODE() {
        return paytpvoperationauthcode;
    }

    /**
     * Define el valor de la propiedad paytpvoperationauthcode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYTPVOPERATIONAUTHCODE(String value) {
        this.paytpvoperationauthcode = value;
    }

}
