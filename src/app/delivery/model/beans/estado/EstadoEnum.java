package app.delivery.model.beans.estado;

public enum EstadoEnum {
    ABERTO,
    ACAMINHO {
        @Override
        public String toString() {
            return "A CAMINHO";
        }
    },
    FECHADO
}