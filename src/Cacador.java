import java.util.List;

public class Cacador implements Ator {
  private Campo campo;
  private Localizacao localizacao;
  private static final int NUM_TIRO = 3;

  public Cacador(Campo campo, Localizacao localizacao) {
    this.campo = campo;
    this.localizacao = localizacao;
  }

  @Override
  public void agir(List<Ator> novoCacadores) {
    Localizacao novaLocalizacao = campo.localizacaoVizinhaLivre();

    if (novaLocalizacao != null) {
      localizacao = novaLocalizacao;
    }
  }

  @Override
  public boolean estaAtivo() {
    return true;
  }
}
