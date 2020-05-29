set -u

NewVersion=2.1
DownloadSite=/home/data/httpd/download.eclipse.org/epsilon
ArchiveSite=/home/data/httpd/archive.eclipse.org/epsilon

echo "downloads before: " && ls $DownloadSite | xargs
echo "archives before: " && ls $ArchiveSite | xargs

# Update the array with previous release(s)
declare -a OldVersions=("obsolete" "1.6" "2.0");
for version in "${OldVersions[@]}"; do
  echo "Moving $version...";
  mkdir $ArchiveSite/$version &&
  mv $DownloadSite/updates/$version/* $ArchiveSite/$version &&
  rm -rf $DownloadSite/updates/$version &&
  mv $DownloadSite/$version/* $ArchiveSite/$version &&
  rm -rf $DownloadSite/$version
done

cd /home/data/httpd/download.eclipse.org/epsilon &&
mkdir $NewVersion && mkdir updates/$NewVersion &&
echo "Copying update site" &&
cp -r interim updates/$NewVersion &&
declare -a NewFolders=("jars" "javadoc");
for folder in "${NewFolders[@]}"; do
  echo "Copying $folder"
  cp -r latest/$folder $NewVersion
done

ant -f /shared/modeling/tools/promotion/manage-composite.xml add -Dchild.repository=$NewVersion

echo "downloads after: " && ls /home/data/httpd/download.eclipse.org/epsilon | xargs;
echo "archives after: " && ls /home/data/httpd/archive.eclipse.org/epsilon | xargs;

#cd /home/data/httpd/download.eclipse.org/epsilon/temp
#curl -o epsilon-${NewVersion}-signed.zip -F file=@epsilon-${NewVersion}-unsigned.zip http://build.eclipse.org:31338/macsign.php
#curl -o epsilon-${NewVersion}-signed.dmg -F sign=true -F source=@epsilon-${NewVersion}-signed.zip http://build.eclipse.org:31338/dmg-packager