$(document).ready(function(){
 
$(".submitForm").click(function(){
	 var submitFormIdElement = document.evaluate(".//form[//button/@id = '" + this.id + "']/@id",document, null,2, null);
	 var submitFormId = submitFormIdElement.stringValue;
     var host = xmlDom.evaluate(".//submit[@form_action_key = '" + submitFormId + "']/server/@host",xmlDom, null,2, null);
     var port = xmlDom.evaluate(".//submit[@form_action_key = '" + submitFormId + "']/server/@port",xmlDom, null,2, null);
     var loginPattern = xmlDom.evaluate(".//submit[@form_action_key = '" + submitFormId + "']/server/@login_pattern",xmlDom, null,2, null);
     var loginKey = xmlDom.evaluate(".//submit[@form_action_key = '" + submitFormId + "']/server/@login_key",xmlDom, null,2, null);
     var platformSolution = xmlDom.evaluate(".//submit[@form_action_key = '" + submitFormId + "']/platform_solution/@pattern",xmlDom, null,2, null);
     var service = xmlDom.evaluate(".//submit[@form_action_key = '" + submitFormId + "']/service/@pattern",xmlDom, null,2, null);
	 var dataMappingKey = xmlDom.evaluate(".//submit[@form_action_key = '" + submitFormId + "']/data_mapping_key/@key",xmlDom, null,2, null);
	 var counterKeyEnable = xmlDom.evaluate(".//submit[@form_action_key = '" + submitFormId + "']/counter/@enable",xmlDom, null,2, null);
	 var counterKey = xmlDom.evaluate(".//submit[@form_action_key = '" + submitFormId + "']/counter/@key",xmlDom, null,2, null);
	 var formDataMappingInfo = xmlDom.evaluate(".//submit[@form_action_key = '" + submitFormId + "']/data_mapping_info",xmlDom, null,5, null);
	 var formURL = ('http://' + host.stringValue + ':' +  port.stringValue  + '/' +  platformSolution.stringValue + loginPattern.stringValue +'/' + loginKey.stringValue + '/' + service.stringValue) ;
     //var addPostData = { dataMappingKey: dataMappingKey.stringValue , formDataMappingInfo : formDataMappingInfo};
	 var formDataMappingInfoElement = formDataMappingInfo.iterateNext();
	 var postData = { dataMappingKey: dataMappingKey.stringValue ,counterKey:counterKey.stringValue,formDataMappingInfo: formDataMappingInfoElement.innerHTML};
	 //postData = postData.serializeArray();
			
	// formURL = "http://192.168.0.205:8080/studio/workbenchService?ns:ns/training/SaveFormDatas";
                  
                 $('#'+ submitFormId).ajaxForm(
                 
                    { 
                        type: "POST",
						data:postData,
                        url:formURL,
                        dataType:  'xml', 
                        beforeSubmit: processData,
                        success: processXml,
                        error: handlingError
                        
                    }
                    ); 
                   
                  
  });
        
});
            function processData() 
            {   
             
            }
           function processXml(responseXML) 
            {   
                var message = $('message', responseXML).text();               
                alert(message); 
            }
           function handlingError() 
            {  
               alert('Submission Error..'); 
            }