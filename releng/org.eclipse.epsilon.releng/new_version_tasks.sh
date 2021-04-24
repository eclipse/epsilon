set -eu

Downloads=/home/data/httpd/download.eclipse.org/epsilon
Archives=/home/data/httpd/archive.eclipse.org/epsilon
UpdatesName=updates
JavadocsName=javadoc
InterimVersion=interim
InterimJavadocs=$InterimVersion-$JavadocsName
NewVersion=2.4
OldVersion=2.3

echo "Moving $OldVersion..." &&
mkdir -p $Archives/$OldVersion &&
cp -r $Downloads/$UpdatesName/$OldVersion/* $Archives/$OldVersion &&
mv $Downloads/$OldVersion/* $Archives/$OldVersion &&
rm -rf $Downloads/$OldVersion &&
cd $Downloads &&
echo "Copying update site..." &&
mkdir -p $UpdatesName/$NewVersion &&
cp -r $InterimVersion/* $UpdatesName/$NewVersion &&
rm -rf $UpdatesName/$NewVersion/$InterimVersion &&
if [ -e $UpdatesName/$NewVersion/epsilon-${InterimVersion}-site.zip ]; then
  mv $UpdatesName/$NewVersion/epsilon-${InterimVersion}-site.zip $UpdatesName/$NewVersion/epsilon-${NewVersion}-site.zip
fi &&
echo "Copying $JavadocsName..." &&
mkdir -p $NewVersion/$JavadocsName &&
cp -r $InterimJavadocs/* $NewVersion/$JavadocsName &&
rm -rf $NewVersion/$JavadocsName/$InterimJavadocs &&
echo "Adding $NewVersion to composite..." &&
cd $Downloads/$UpdatesName &&
ant -f /shared/modeling/tools/promotion/manage-composite.xml add -Dchild.repository=$NewVersion

#cd /home/data/httpd/download.eclipse.org/epsilon/temp
#curl -o epsilon-${NewVersion}-signed.zip -F file=@epsilon-${NewVersion}-unsigned.zip http://build.eclipse.org:31338/macsign.php
#curl -o epsilon-${NewVersion}-signed.dmg -F sign=true -F source=@epsilon-${NewVersion}-signed.zip http://build.eclipse.org:31338/dmg-packager