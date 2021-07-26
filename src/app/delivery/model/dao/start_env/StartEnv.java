package app.delivery.model.dao.start_env;

import app.delivery.model.dao.start_env.data.CreateCliente;
import app.delivery.model.dao.start_env.data.CreateForma;
import app.delivery.model.dao.start_env.data.CreatePedido;
import app.delivery.model.dao.start_env.data.CreatePizza;
import app.delivery.model.dao.start_env.data.CreatePizzaSabor;
import app.delivery.model.dao.start_env.data.CreateSabor;
import app.delivery.model.dao.start_env.data.CreateTables;

public class StartEnv {
    public static void main(String[] args) {
        CreateTables.main(args);
        
        CreateCliente.main(args);
        CreatePedido.main(args);
        CreateSabor.main(args);
        CreateForma.main(args);
        CreatePizza.main(args);
        CreatePizzaSabor.main(args);
    }
}
