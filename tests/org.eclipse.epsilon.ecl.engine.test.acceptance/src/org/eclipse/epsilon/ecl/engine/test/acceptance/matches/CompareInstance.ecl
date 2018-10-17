rule TLN 
	match l : Left!TLN with r : Right!TLN extends TAnyLN {
	compare : l.text=r.text
}

@lazy
@abstract
rule TAnyLN 
	match l : Left!TAnyLN with r : Right!TAnyLN {
	compare : l.text1 = r.text1
	do {
		if (not l.dOI.asBag().matches(r.dOI.asBag()) or not r.dOI.asBag().matches(l.dOI.asBag()))
			throw "[TAnyLN] Expected match on unordered collection.";
	}
}

@lazy
rule TDOI_lr
	match l : Left!TDOI with r : Right!TDOI {
	compare : l.access = r.access
	do {
		l.accessControl.print(" # TDOI-l:");
		r.accessControl.println(" <-> TDOI-r:");
	}
}

@lazy
rule TDOI_rl
	match r : Right!TDOI with l : Left!TDOI {
	compare : r.access = l.access
	do {
		r.accessControl.print(" # TDOI-r:");
		l.accessControl.println(" <-> TDOI-l:");
	}
}

post {
  for (m in System.context.matchTrace.getMatches()) {
    ("Match:" + m.matching + /*  " - Info:" + m.Info + */  " - " + m.left + " <-> " + m.right).println();
  }
}