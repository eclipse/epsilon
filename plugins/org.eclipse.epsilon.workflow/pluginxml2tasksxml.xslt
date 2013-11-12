<?xml version="1.0"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
	<antlib>
		<xsl:for-each select="//antTask">
	        <taskdef>
				<xsl:attribute name="name">
					<xsl:value-of select="@name" />
				</xsl:attribute>
				<xsl:attribute name="classname">
					<xsl:value-of select="@class" />
				</xsl:attribute>
	        </taskdef>
      	</xsl:for-each>
	</antlib>
</xsl:template>

</xsl:stylesheet>