/**
 * 
 */
(function() {
  var app = angular.module('InserisciTipologia', []);

  app.controller('TipologiaController', ['$scope', '$http' ,function($scope, $http){
	  
    var tipologia = this;
    tipologia.risultati = [];
    //tipologia.preRequisiti = [];
    
    $scope.rispostaDalPost ="";
    $scope.dettaggliErrore ="";
    
    tipologia.sendDati=function(){
    	var data= {
    		nome: $scope.nome,
    		codice: $scope.codice,
    		descrizione: $scope.descrizione,
    		costo: $scope.costo,
    		risultati: tipologia.risultati
    		//preRequisiti: tipologia.preRequisiti
    	};
    	
    	$http.post('progettoSiwClinica/controllerTipologiaEsame',data)
        .succes(function(){
        	$scope.rispostaDalPost = "POST effettuato con Successo";
        })
        .error(function(){
        	$scope.dettaggliErrore = "Errore nel POST";
        });
        
    	
    };
    
  }]);
  
  
  
  app.controller('RisultatiController', function(){
	  this.text="";
	  
	  
	  this.addRisultato=function(tipologia){
	    	tipologia.risultati.push(this.text);
	    	this.text="";
	    };
	  
	  });
  
  

 
})();
