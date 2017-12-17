
List dat is as below (size):<#if showList??> ${showList?size}<#else> 0 </#if>

<#if showList?? && showList?has_content>
<table>
<tr>
	<th>ID</th>
	<th>Input data</th>
	<th>Sorted Data</th>
	<th>movements</th>
</tr>
<#list showList as element>
	<tr>
		<td>ID</td>
		<td>Input data</td>
		<td>Sorted Data</td>
		<td>movements</td>
	</tr>
</#list>
</table>

<#else>
No data available!
</#if>  
<button type="button" id="back-btn"> back </button>
  
