package com.zp.study.search.lucene.test;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Author: Zhang Peng
 * Date: 2017/1/18 0018
 * Description: Lucene使用学习
 */
public class LuceneTest {
    public static void main(String[] args) {
        LuceneTest test = new LuceneTest();
        System.out.println("操作开始");
        Directory directory = null;
        try {
            // 1. 初始化分词器，拆分单词
            Analyzer analyzer = new StandardAnalyzer();
            // 2. 构建索引目录
//            directory = FSDirectory.open(FileSystems.getDefault().getPath("D:\\Download\\UC Download\\index"));
            directory = new RAMDirectory();
            test.write(directory, analyzer);
            System.out.println("写完成");
            test.read(directory, analyzer);
            System.out.println("操作完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (directory != null) {
                try {
                    directory.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void write(Directory directory, Analyzer analyzer) {
        IndexWriter indexWriter = null;
        try {
            IndexWriterConfig config = new IndexWriterConfig(analyzer);
            indexWriter = new IndexWriter(directory, config);
            // 删除原来的数据
            indexWriter.deleteAll();
            File dFile = new File("D:\\Download\\UC Download");
            File[] files = dFile.listFiles();
            for (File file : files) {
                // 3、创建Document对象
                Document document = new Document();
                // 4、为Document添加Field
                System.out.println("fileName = " + file.getName());
                if (file.isDirectory()) {
                    continue;
                }
                // 第三个参数是FieldType 但是定义在TextField中作为静态变量
                document.add(new Field("content", new FileReader(file), TextField.TYPE_NOT_STORED));
                document.add(new TextField("filename", file.getName(), Field.Store.YES));
                document.add(new StringField("filepath", file.getAbsolutePath(), Field.Store.YES));
                // 5、通过IndexWriter添加文档到索引中
                indexWriter.addDocument(document);
            }
            // 提交
            indexWriter.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (indexWriter != null) {
                try {
                    // 关闭资源
                    indexWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void read(Directory directory, Analyzer analyzer) {
        IndexReader indexReader = null;
        indexReader = null;
        try {
            indexReader = DirectoryReader.open(directory);
            IndexSearcher indexSearcher = new IndexSearcher(indexReader);

            String searchFieldName = "content";
            // key和分词器有关，StandardAnalyzer不拆分“.”
            String searchKey = "apk";
            int searchSize = 100;

            QueryParser queryParser = new QueryParser(searchFieldName, analyzer);
            // 创建Query表示搜索域为content包含UIMA的文档
            Query query = queryParser.parse(searchKey);

            // 根据searcher搜索并且返回TopDocs
            TopDocs topDocs = indexSearcher.search(query, searchSize);
            System.out.println("查找到的文档总共有：" + topDocs.totalHits);

            // 根据TopDocs获取ScoreDoc对象
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;

            for (int i = 0; i < scoreDocs.length; i++) {
                Document hitDoc = indexSearcher.doc(scoreDocs[i].doc);
                System.out.println(hitDoc.get("filename"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (indexReader != null) {
                try {
                    indexReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (directory != null) {
                try {
                    directory.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
