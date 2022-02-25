package es.supermercado.comida;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comida {
    private long id = -1;
    private String descripcion;
    private boolean checked;

    public void setId(long id) {
        this.id = id;
    }
}
