package classes;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import tests.CadastrarProcessoTest;
import tests.ConsultarProcessoTest;
import tests.ExcluirProcessoTest;
import tests.ListarProcessosTest;
import tests.ValidarLoginTest;

public class TestRunner {
   
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(ValidarLoginTest.class);
		if (result.wasSuccessful()) {
			System.out.println("ValidarLogin OK.");
		} else {
			for (Failure failure : result.getFailures()) {
				System.out.println(failure.toString());
			}
		}

		result = JUnitCore.runClasses(ListarProcessosTest.class);
		if (result.wasSuccessful()) {
			System.out.println("ListarProcessos OK.");
		} else {
			for (Failure failure : result.getFailures()) {
				System.out.println(failure.toString());
			}
		}

		result = JUnitCore.runClasses(ConsultarProcessoTest.class);
		if (result.wasSuccessful()) {
			System.out.println("ConsultarProcesso OK.");
		} else {
			for (Failure failure : result.getFailures()) {
				System.out.println(failure.toString());
			}
		}

		result = JUnitCore.runClasses(CadastrarProcessoTest.class);
		if (result.wasSuccessful()) {
			System.out.println("CadastrarProcesso OK.");
		} else {
			for (Failure failure : result.getFailures()) {
				System.out.println(failure.toString());
			}
		}

		result = JUnitCore.runClasses(ExcluirProcessoTest.class);
		if (result.wasSuccessful()) {
			System.out.println("ExcluirProcesso OK.");
		} else {
			for (Failure failure : result.getFailures()) {
				System.out.println(failure.toString());
			}
		}
	}

}  