package br.com.zg.glosa.jobs;


import br.com.zg.glosa.model.Conciliacao;
import br.com.zg.glosa.model.Guia;
import br.com.zg.glosa.service.ConciliacaoService;
import br.com.zg.glosa.service.GuiaService;
import br.com.zg.glosa.service.QuitacaoGuiaService;
import br.com.zg.glosa.service.QuitacaoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class InsercaoArquivosJob {

    @Autowired
    private GuiaService guiaService;

    @Autowired
    private QuitacaoGuiaService quitacaoGuiaService;

    @Autowired
    private QuitacaoItemService quitacaoItemService;

    @Autowired
    private ConciliacaoService conciliacaoService;

    public void tratarDadosArquivos() {
        DocumentBuilder dBuilder;
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        File[] arquivos = listarTodosArquivos("xml");
        List<Conciliacao> conciliacoes = new ArrayList<>();

        for (File arquivo: arquivos) {
            try {
                dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(arquivo);
                doc.getDocumentElement().normalize();

                NodeList nodeList = doc.getElementsByTagName("row");
                for (int i = 0; i < nodeList.getLength(); i++) {
                    conciliacoes.add(getConciliacao(nodeList.item(i)));
                }

                conciliacoes.isEmpty();
            } catch (SAXException | ParserConfigurationException | IOException e1) {
                e1.printStackTrace();
            }

        }


        inserirDados(conciliacoes);

    }

    private void inserirDados(List<Conciliacao> conciliacoes) {

        for (Conciliacao conciliacao : conciliacoes) {
            Guia guia = guiaService.pesquisar(conciliacao.getNumeroGuia());

            if(guia != null) {
                quitacaoGuiaService.salvar(guia, conciliacao.getDataPagamento(), conciliacao.getValorPago());
                quitacaoItemService.salvar(guia, conciliacao.getValorApresentado(), conciliacao.getCodigoMotivo(), conciliacao.getDescricaoMotivo());
            }

            conciliacaoService.adicionarConciliacao(conciliacao);
        }


    }

    private Conciliacao getConciliacao(Node node) {
        Conciliacao conciliacao = new Conciliacao();

        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            conciliacao.setConvenio(getTagValue("convenio", element));

            try {
                Date data =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(getTagValue("data_pagamento", element));
                conciliacao.setDataPagamento(data);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            conciliacao.setNumeroProtocolo(Long.valueOf(getTagValue("numero_protocolo", element)));
            conciliacao.setMatricula(getTagValue("matricula", element));
            conciliacao.setNome(getTagValue("nome", element));
            conciliacao.setNumeroGuia(getTagValue("numero_guia", element));
            conciliacao.setNgPrest(Long.valueOf(getTagValue("ng_prest", element)));
            conciliacao.setSenhaGuia(getTagValue("senha_guia", element));
            conciliacao.setCodigoProduto(Long.valueOf(getTagValue("codigo_produto", element)));
            conciliacao.setDescricaoProduto(getTagValue("descricao_produto", element));
            conciliacao.setValorApresentado(Double.valueOf(getTagValue("valor_apresentado", element)));
            conciliacao.setValorPago(Double.valueOf(getTagValue("valor_pago", element)));
            conciliacao.setValorGlosa(Double.valueOf(getTagValue("valor_glosa", element)));
            conciliacao.setDescricaoMotivo(getTagValue("descricao_motivo", element));
            conciliacao.setCodigoMotivo(Long.valueOf(getTagValue("codigo_motivo", element)));
        }

        return conciliacao;
    }


    private String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node != null ? node.getNodeValue() : null;
    }

    private File[] listarTodosArquivos(String extensao) {
        File dir = new File("arquivos/");
        File [] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("." + extensao);
            }
        });

        return files;
    }
}
