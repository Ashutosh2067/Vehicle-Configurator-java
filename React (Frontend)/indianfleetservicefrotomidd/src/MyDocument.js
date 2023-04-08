import React from 'react';
import { PDFDownloadLink, Document, Page, Text, View, StyleSheet } from '@react-pdf/renderer';

const MyDocument = ({ data }) => {
  const styles = StyleSheet.create({
    page: {
      flexDirection: 'row',
      backgroundColor: '#E4E4E4'
    },
    section: {
      margin: 10,
      padding: 10,
      flexGrow: 1
    }
  });

  return (
    <>
      <PDFDownloadLink document={<Document>
        <Page size="A4" style={styles.page}>
          <View style={styles.section}>
            <Text>Standard Features:</Text>
            {data.TypeSWithZero.map(p => (
              <View key={p.compId}>
                <Text>{p.compName}</Text>
                <Text>{p.altCompId}</Text>
              </View>
            ))}
          </View>
          <View style={styles.section}>
            <Text>Interior Features:</Text>
            {data.TypeIWithZero.map(p => (
              <View key={p.compId}>
                <Text>{p.compName}</Text>
                <Text>{p.altCompId}</Text>
              </View>
            ))}
          </View>
          <View style={styles.section}>
            <Text>Exterior Features:</Text>
            {data.TypeEWithZero.map(p => (
              <View key={p.compId}>
                <Text>{p.compName}</Text>
                <Text>{p.altCompId}</Text>
              </View>
            ))}
          </View>
        </Page>
      </Document>} fileName="myDocument.pdf">
        {({ blob, url, loading, error }) =>
          loading ? 'Loading document...' : 'Download PDF'
        }
      </PDFDownloadLink>
    </>
  );
}

export default MyDocument;
