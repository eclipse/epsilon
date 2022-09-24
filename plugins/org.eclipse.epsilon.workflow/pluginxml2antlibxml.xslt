<xsl:stylesheet version="1.0" exclude-result-prefixes="xalan str" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xalan="http://xml.apache.org/xalan" xmlns:str="xalan://java.lang.String">
<xsl:output indent="yes" method="xml" xalan:indent-amount="4" omit-xml-declaration="yes"/>
<xsl:param name="removePrefix"/>
<xsl:template match="/">
	<xsl:element name="antlib">
		<xsl:for-each select="//antTask">
	        <xsl:element name="taskdef">
				<xsl:attribute name="name">
					<xsl:value-of select="str:replaceAll(str:new(@name), $removePrefix, '')" />
				</xsl:attribute>
				<xsl:attribute name="classname">
					<xsl:value-of select="@class" />
				</xsl:attribute>
	        </xsl:element>
      	</xsl:for-each>
	</xsl:element>
</xsl:template>
</xsl:stylesheet>