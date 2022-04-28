package Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Clase18Application {

	public static void main(String[] args) {
		SpringApplication.run(Clase18Application.class, args);
	}
}

/* (en controller) model.addAttribute("atributName", valor);
 * (en html) <etiqueta th:text="${atributName} +' '+ ${otroAtribut}">
 * (en html) <etiqueta th:each="data:${atributCollection}>
 * 				<otraEtiqueta th:text="${data.name}"
 * (en html) <etiqueta th:if="${atributName}== valor th:text="algo"
 * 			  th:unless="${atributName}== otroValor th:text="otro algo">
 * (en html) <etiqueta th:switch="${atributName}>
 * 				
 * */
 