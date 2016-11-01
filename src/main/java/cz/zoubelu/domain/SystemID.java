package cz.zoubelu.domain;

/**
 * Created by zoubas on 10.7.16.
 * This enum represents the application schema of graph database
 */
public enum SystemID {

	PEGAS_KUKÁTKO("PEGAS-KUKÁTKO", 100),
	SCA("SCA", 101),
	PORADCE("PORADCE", 102),
	HUGO("HUGO", 103),
	FAC_APP("FAC-APP", 104),
	PŠP_KLIENT_DESKTOPOVÁ_APLIKACE("PŠP KLIENT DESKTOPOVÁ APLIKACE", 107),
	BERTA("BERTA", 108),
	EREGRESY("EREGRESY", 109),
	EAGENTI("EAGENTI", 110),
	FIP("FIP-PARTNERS", 111),
	SFTPBRIDGE("SFTPBRIDGE", 112),
	WEB_GENERALI("WEB GENERALI", 113),
	NEDORUČENÁ_POŠTA_LN("NEDORUČENÁ POŠTA LN", 114),
	MESSAGE_HOUSE("MESSAGE_HOUSE", 115),
	EPOHLEDAVKY("EPOHLEDAVKY", 116),
	LISA("LISA", 141),
	JOK_CLK("JOK/CLK", 142),
	MICROSITE_POV("MICROSITEPOV", 201),
	AWD("AWD", 1000),
	NHUGO("NHUGO", 1001),
	UNICREDIT_LEASING("UNICREDIT LEASING", 1003),
	INSIA("INSIA", 1004),
	MODUL_SERVIS("MODUL SERVIS", 1005),
	TOTAL_BROKERS("TOTAL BROKERS", 1006),
	PFP("PFP", 1007),
	FIXUM("FIXUM", 1008),
	DATALIFE("DATALIFE", 1009),
	OK_GROUP("OK_GROUP", 1010),
	SALVE_FINANCE("SALVE FINANCE", 1011),
	RENOMIA("RENOMIA", 1012),
	INWEB("INWEB", 1013),
	SMS_FINANČNÍ_PORADENSTVÍ("SMS FINANČNÍ PORADENSTVÍ", 1014),
	FSS_PARTNERS_("FSS + PARTNERS_", 1015),
	VOLKSWAGEN_FINANCIAL_SERVICES_("VOLKSWAGEN_FINANCIAL_SERVICES_", 1016),
	AXIMA_SPOL("AXIMA_SPOL.S.R.O", 1017),
	ČESKÝ_OBCHODNÍ_SERVIS("ČESKÝ_OBCHODNÍ_SERVIS", 1018),
	FEDS("FEDS", 1019),
	OVB("OVB", 1020),
	FINCENTRUM("FINCENTRUM", 1021),
	ALLRISK("ALLRISK", 1022),
	EFINANCE("EFINANCE", 1023),
	INPOL("INPOL", 1024),
	SROVNÁVAČ("SROVNÁVAČ", 1025),
	IBM_MB("IBM_MB", 0),
	CZGUSRMNG("GUSRMNG", 1),
	GZGUCINFO("GUCINFO", 2),
	GZGPOLINFO("GPOLINFO", 3),
	CZGPOLICING("GPOLICING", 4),
	CZGMESSAGING("GMESSAGING", 5),
	CZGCALCBM("GCALCBM", 6),
	CZGDELIVERY("GDELIVERY", 7),
	CZGPRINTS("GPRINTS", 8),
	CZGDA("GDA", 9),
	CZGCLAIMS("CZGCLAIMS", 12),
	CZGCODELIST("CZGCODELIST", 13),
	CZGCARPRICING("CZGCARPRICING", 14),
	CZGPRODCATALOG("CZGPRODCATALOG", 15),
	CZGCONTRACTUPDATE("CZGCONTRACTUPDATE",555),
	CZGAGENTINFO("CZGAGENTINFO", 16),
	CZGEARNIX("CZGEARNIX", 17),
	CZGSEARCH("CZGSEARCH", 18),
	CZGCOMM("CZGCOMM", 19),
	CZGLEADMNG("CZGLEADMNG", 20),
	CZGBLACKLISTING("CZGBLACKLISTING", 21),
	CZGCONTRACTIMPORTPMV("CZGCONTRACTIMPORTPMV", 22),
	CZGPROCESSSUPPORT("CZGPROCESSSUPPORT", 23),
	CZCTIA("CZCTIA", 24),
	MONITORING("MONITORING", 99),
	CZGLISA("CZGLISA", 141);

	/*
		MESSAGE_HOUSE("MESSAGE HOUSE",134),
		CZGAGENTINFO("CZGAGENTINFO",11),
	*/
	private Integer id;
	private String systemName;

	SystemID(String systemName, Integer id) {
		this.id = id;
		this.systemName = systemName;
	}

	public Integer getID() {
		return this.id;
	}

	public String getSystemName() {
		return systemName;
	}

	public static String getSystemByID(Integer id) {
		for (SystemID system : values()) {
			if ((id).equals(system.getID())) {
				return system.getSystemName();
			}
		}
		return id.toString();
	}

	public static Integer getIdByName(String name){
		for (SystemID system : values()) {
			if (name.equals(system.getSystemName())){
				return system.getID();
			}
		}
		try {
			return valueOf(name).getID();
		}catch (IllegalArgumentException e){
			throw new IllegalArgumentException(
					"Nepodarilo se ziskat systemID jelikoz v ciselniku neni aplikace: " + name);
		}
	}
}