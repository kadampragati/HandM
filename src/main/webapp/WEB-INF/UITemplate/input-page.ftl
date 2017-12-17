<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html lang="en">
<head>
<script src="static/JQuery/jquery-3.2.1.min.js"></script>
<script src="static/js/input-page.js"></script>
</head>
<body>

<br><br>
<div id="main-page-div">
<div id="sort-input-div">
<#include "input-data-page.ftl">
</div>

<div id="sort-data-div">

<#if success?? && success=='true'>
<div>
data saved successfully!
</div>
sorted list is : ${details.sortedVal!"Not found"}
<button type="button" id="save-btn" href="#"> save it </button>
</#if>
</div> 
</div>
</body>
</html>    
