<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
  <html>
  <body>
    <h2>Epsilon Update Site</h2>
    This site is designed to be used through the Eclipse update manager, which is accessible
    within Eclipse under <b>Help->Software Updates</b>. For instructions on how to install Epsilon using this site, please refer to
    the <a href="http://www.eclipse.org/gmt/epsilon/doc/P2InstallationGuide.pdf">installation guide</a>.
    
    <p>
    	<b><font color="green">Note:</font></b> This update site contains the
    	latest stable version of Epsilon. For a more recent - but potentially
    	unstable - version of Epsilon, please use the <a href="http://download.eclipse.org/modeling/gmt/epsilon/interim/">interim update site</a> instead.
    </p>
    
    <h2>Features</h2>
    <table border="1">
    <tr bgcolor="#666699" style="color:#ffffff">
      <th align="left">Feature</th>
      <th align="left">Version</th>
    </tr>
    <xsl:for-each select="site/feature">
    <tr>
      <td><xsl:value-of select="@id"/></td>
      <td><xsl:value-of select="@version"/></td>
    </tr>
    </xsl:for-each>
    </table>
    <br/>
    <b>Note:</b> The last part of the version number (qualifier) is the date/time when the release
    was built (times in GMT zone). For example, if the version of a feature is 
    0.8.4.200902120929, it means that it is version 0.8.4 built at 09:29 on
    12/02/2009.
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>