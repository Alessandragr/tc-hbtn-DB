import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO{
    Connection connection = null;
    @Override
    public Connection connect(String urlConexao) {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(urlConexao);
                System.out.println("UP");
            } else if (connection.isClosed()) {
                connection = null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void createTable(String urlConexao) {
        String create = "CREATE TABLE IF NOT EXISTS Cliente (" + " id integer PRIMARY KEY AUTO_INCREMENT," +
                "nome VARCHAR (100) NOT NULL," + "idade INTEGER NOT NULL," +
                "CPF VARCHAR(15) NOT NULL," + "RG VARCHAR(20) NOT NULL)";

        try {
            connect(urlConexao);
            PreparedStatement preparedStatement = connection.prepareStatement(create);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(String url_conexao, Cliente cliente) {
        try {
            String insert = "INSERT INTO Cliente (nome, idade, CPF, RG) VALUES (?, ?, ?, ?)";
            connect(url_conexao);
            PreparedStatement preparedStatement;

            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setInt(1, cliente.getIdade());
            preparedStatement.setString(1, cliente.getCpf());
            preparedStatement.setString(1, cliente.getRg());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void selectAll(String urlConexao) {

        try {
            String select = "SELECT * FROM Cliente";
            connect(urlConexao);
                Statement statement = connection.createStatement();
                if (statement != null) {
                    statement.executeQuery(select);
                }
          } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String urlConexao, int id, String name, Integer idade) {
        try {
            connect(urlConexao);
            String update = "UPDATE Cliente SET nome = (?), idade = (?) WHERE id = (?)";

            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, idade);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String urlConexao, int id) {
        try {
            connect(urlConexao);
            String delete = "DELETE FROM Cliente WHERE ID = (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
