-- criando tabela transacoes
CREATE TABLE transacoes
(
    id INT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(255)  NOT NULL COMMENT 'descreve o que foi a movimentação, exemplos, salário, supermercado, conta de luz,...',
    tipo VARCHAR(20) NOT NULL COMMENT 'Pode ser receita ou despesa',
    categoria VARCHAR(100)  NOT NULL COMMENT 'classifica a transação, exemplos, alimentação, moradia, transporte, lazer,...',
    valor DECIMAL(10, 2) NOT NULL,
    data_transacao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);
-- validação para não armazenar valores menores ou iguais a zero na coluna valor

ALTER TABLE transacoes
ADD CONSTRAINT valor_maior_que_zero
CHECK (valor > 0);