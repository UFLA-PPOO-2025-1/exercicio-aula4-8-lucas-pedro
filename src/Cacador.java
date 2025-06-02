import java.util.Iterator;
import java.util.List;

public class Cacador implements Ator {
  private Campo campo;
  private Localizacao localizacao;
  private static final int NUM_TIRO = 3;

  public Cacador(Campo campo, Localizacao localizacao) {
    this.campo = campo;
    this.localizacao = localizacao;

    campo.colocar(this, localizacao);
  }

  /**
   * Coloca o caçador na nova localização no campo fornecido.
   * 
   * @param novaLocalizacao A nova localização do animal.
   */
  @Override
  public void definirLocalizacao(Localizacao novaLocalizacao) {
    if (localizacao != null) {
      campo.limpar(localizacao);
    }
    localizacao = novaLocalizacao;
    campo.colocar(this, novaLocalizacao);
  }

  @Override
  public void agir(List<Ator> novoCacadores) {

    // Teleporta-se pra uma localização livre
    Localizacao novaLocalizacao = campo.localizacaoVizinhaLivre();

    // Define a localização
    definirLocalizacao(novaLocalizacao);

    // Fazer ataque
    atirar();
  }

  private void atirar() {
    List<Localizacao> alvos = campo.localizacoesTotais();
    Iterator<Localizacao> it = alvos.iterator();
    int cont = 0;
    while (it.hasNext() && cont < NUM_TIRO) {
      Localizacao onde = it.next();
      Object animal = campo.obterObjetoEm(onde);
      if (animal instanceof Animal) {
        Animal alvo = (Animal) animal;
        if (alvo.estaAtivo()) {
          alvo.morrer();
        }
      }
      cont++;
    }
  }

  @Override
  public boolean estaAtivo() {
    return true;
  }
}
