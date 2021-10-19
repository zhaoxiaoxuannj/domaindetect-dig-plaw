#!/bin/bash
domain=$1
digresult=`dig $domain`
result=`echo ${digresult}|awk -F';; ANSWER SECTION:' '{print $2}'|awk -F';;' '{print $1}'|awk -F' IN A ' '{ for(i=2; i<=NF; i++){ print($i) }}'|awk -F' ' '{print $1}'`
#echo ${result}
echo ${result/\ \/;}

