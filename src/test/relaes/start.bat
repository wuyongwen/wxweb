@echo off
echo 正在启动，请稍后....

set PATH=%JAVA_HOME%\bin
set JNA_HOME=.
set CLASSPATH=.;%JNA_HOME%\conf

FOR %%F IN (%JNA_HOME%\lib\*.jar) DO call :addcp %%F

goto extlibe

:addcp
set CLASSPATH=%CLASSPATH%;%1
goto :eof

:extlibe

java -Xms300m -Xmx400m wxweb.Start