set -u

Downloads=/home/data/httpd/download.eclipse.org/epsilon
Archives=/home/data/httpd/archive.eclipse.org/epsilon

NewVersion=2.1
OldVersion=2.0
InterimVersion=interim

echo "Moving $OldVersion..." &&
mkdir -p $Archives/$OldVersion &&
cp -r $Downloads/updates/$OldVersion/* $Archives/$OldVersion &&
mv $Downloads/$OldVersion/* $Archives/$OldVersion &&
rm -rf $Downloads/$OldVersion

cd $Downloads &&
echo "Copying $InterimVersion to $NewVersion" &&
mkdir $NewVersion &&
cp -r $InterimVersion/* updates/$NewVersion
if [ -e updates/epsilon-${InterimVersion}-site.zip ]; then
  mv updates/epsilon-${InterimVersion}-site.zip updates/epsilon-${NewVersion}-site.zip
fi
declare -a NewFolders=("javadoc" "jars");
for folder in "${NewFolders[@]}"; do
  if [ -d updates/$NewVersion/$folder ]; then
    mv updates/$NewVersion/$folder $NewVersion/$folder
  fi
done

cd updates &&
rm -rf $NewVersion/interim &&
ant -f /shared/modeling/tools/promotion/manage-composite.xml add -Dchild.repository=$NewVersion

#cd /home/data/httpd/download.eclipse.org/epsilon/temp
#curl -o epsilon-${NewVersion}-signed.zip -F file=@epsilon-${NewVersion}-unsigned.zip http://build.eclipse.org:31338/macsign.php
#curl -o epsilon-${NewVersion}-signed.dmg -F sign=true -F source=@epsilon-${NewVersion}-signed.zip http://build.eclipse.org:31338/dmg-packager