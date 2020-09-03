set -eu

Downloads=/home/data/httpd/download.eclipse.org/epsilon
Archives=/home/data/httpd/archive.eclipse.org/epsilon
UpdatesName=updates
JavadocsName=javadocs
InterimVersion=interim
InterimJavadocs=$InterimVersion-$JavadocsName
NewVersion=2.2
OldVersion=2.1

echo "Moving $OldVersion..." &&
mkdir -p $Archives/$OldVersion &&
cp -r $Downloads/$UpdatesName/$OldVersion/* $Archives/$OldVersion &&
mv $Downloads/$OldVersion/* $Archives/$OldVersion &&
rm -rf $Downloads/$OldVersion

cd $Downloads &&
echo "Copying update site..." &&
mkdir -p $UpdatesName/$NewVersion &&
cp -r $InterimVersion/* $UpdatesName/$NewVersion
if [ -e $UpdatesName/$NewVersion/epsilon-${InterimVersion}-site.zip ]; then
  mv $UpdatesName/$NewVersion/epsilon-${InterimVersion}-site.zip $UpdatesName/$NewVersion/epsilon-${NewVersion}-site.zip
fi &&
echo "Copying $JavadocsName..." &&
mkdir -p $NewVersion/$JavadocsName &&
cp -r $InterimJavadocs/* $NewVersion/$JavadocsName &&
echo "Adding $NewVersion to composite..." &&
cd $UpdatesName &&
rm -rf $NewVersion/interim &&
ant -f /shared/modeling/tools/promotion/manage-composite.xml add -Dchild.repository=$NewVersion

#cd /home/data/httpd/download.eclipse.org/epsilon/temp
#curl -o epsilon-${NewVersion}-signed.zip -F file=@epsilon-${NewVersion}-unsigned.zip http://build.eclipse.org:31338/macsign.php
#curl -o epsilon-${NewVersion}-signed.dmg -F sign=true -F source=@epsilon-${NewVersion}-signed.zip http://build.eclipse.org:31338/dmg-packager