
# Book Library  (Java)

first clone project

```bash
git clone https://github.com/SeyedAb2/book-library.git
```
there is to branch
### if you want work with files 
```bash
git checkout withFiles
```
then run `MainCli.java`
files save in `store` folder

### if you want work with database
```bash
git checkout withDataBase
```
####download tools
* for use MySql we need local serve ,so we can use [xampp](https://www.apachefriends.org/download.html)
* after that we need create connection driver , use [mysql-connector](https://dev.mysql.com/downloads/connector/j/) 
* install `database-navigator` plugin for plugin layout of intellj

####installing 
* run xampp and start `apache` , `mysql`
* open this [url](http://localhost/phpmyadmin/index.php) on browser
* in phpMyAdmin import `javalibrary.sql` in your mysql database
* copy `mysql-connector-java-8.0.29.jar` to folder project

#### this [youtube](https://www.youtube.com/watch?v=e8g9eNnFpHQ) link learn you how to connect to mysql in intellj

after that you need create a connection between your project and mysql
* use tab DBNavigator to define a connection
* after that `right-click` on `src` folder `DB Navigator`=> `Associate Connection` .
* choose connection name you defined before
* go `file` => `Project Structure` => `Modules` => `Dependencies` tab and click `+` icon , then `Library` => `Java` , choose `mysql-connector-java-8.0.29.jar` from your project, at end change it scope to `compile`

then run `MainCli.java`

