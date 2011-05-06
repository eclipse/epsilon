# Note: install latexmk before using this Makefile!
JOB=EpsilonBook
.PHONY: all clean

all: $(JOB).pdf

$(JOB).pdf: *.tex */*.tex *.bib
	latexmk -pdf $(JOB)

review: $(JOB).pdf
	xdg-open $(JOB).pdf
	latexmk -pvc -pdf $(JOB)

clean:
	latexmk -C $(JOB)
