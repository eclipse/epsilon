set -u

Downloads=/home/data/httpd/download.eclipse.org/epsilon
Archives=/home/data/httpd/archive.eclipse.org/epsilon

NewVersion=2.1
OldVersion=2.0

echo "downloads before: " && ls $Downloads | xargs
echo "archives before: " && ls $Archives | xargs

echo "Moving $OldVersion...";
mkdir $Archives/$OldVersion &&
mv $Downloads/updates/$OldVersion/* $Archives/$OldVersion &&
rm -rf $Downloads/updates/$OldVersion &&
mv $Downloads/$OldVersion/* $Archives/$OldVersion &&
rm -rf $Downloads/$OldVersion

cd $Downloads &&
echo "Copying interim to $NewVersion" &&
cp -r interim updates/$NewVersion
if [ -e updates/epsilon-interim-site.zip]; then
  mv updates/epsilon-interim-site.zip updates/epsilon-${$NewVersion}-site.zip
fi
declare -a NewFolders=("javadoc" "jars");
for folder in "${NewFolders[@]}"; do
  if [ -d updates/$NewVersion/$folder ]; then
    mv updates/$NewVersion/$folder $NewVersion/$folder
  fi
done

ant -f /shared/modeling/tools/promotion/manage-composite.xml add -Dchild.repository=$NewVersion

echo "downloads after: " && ls /home/data/httpd/download.eclipse.org/epsilon | xargs;
echo "archives after: " && ls /home/data/httpd/archive.eclipse.org/epsilon | xargs;

#cd /home/data/httpd/download.eclipse.org/epsilon/temp
#curl -o epsilon-${NewVersion}-signed.zip -F file=@epsilon-${NewVersion}-unsigned.zip http://build.eclipse.org:31338/macsign.php
#curl -o epsilon-${NewVersion}-signed.dmg -F sign=true -F source=@epsilon-${NewVersion}-signed.zip http://build.eclipse.org:31338/dmg-packager