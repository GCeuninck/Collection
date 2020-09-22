package collection.tsio;

import collection.tsio.Contact;

public class NumTel extends Contact {
	
	enum TypeTel { FIXEPROF, FIXEDOM, PORTABLE, FAX };
	
	protected String numero;
	protected TypeTel type;
	
	public NumTel(String numero, TypeTel type) {
		this.numero = numero;
		this.type = type;
	}

	public String getNumero() {
		return numero;
	}

	public TypeTel getType() {
		return type;
	}
	
	@Override
	public String toString() {
		String prefix = null;
		switch(type) {
		case FIXEPROF : prefix = "professionel"; break;
		case FIXEDOM : prefix = "domicile" ; break;
		case PORTABLE : prefix = "portable" ; break;
		case FAX : prefix = "fax" ; break;
		}
		return prefix  + ":" + numero;
	}
	
}
