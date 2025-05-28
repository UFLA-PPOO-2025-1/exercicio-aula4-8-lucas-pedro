
import java.awt.Color;

public class VisaoDeTexto implements VisaoSimulador {

  private EstatisticasCampo estatisticas;

  public VisaoDeTexto() {
    estatisticas = new EstatisticasCampo();
  }

  @Override
  public void definirCor(Class<?> classeAnimal, Color cor) {
    // nada a fazer nesta classe
  }

  @Override
  public void reabilitarOpcoes() {
    // nada a fazer nesta classe
  }

  @Override
  public void reiniciar() {
    estatisticas.reiniciar();
  }

  @Override
  public boolean ehViavel(Campo campo) {
    return estatisticas.ehViavel(campo);
  };

  @Override
  public void mostrarStatus(int passo, Campo campo) {
    estatisticas.reiniciar();
    System.out.print("Passo: " + passo + " - ");
    String text = estatisticas.obterDetalhesPopulacao(campo);
    System.out.println(text);
  }
}
