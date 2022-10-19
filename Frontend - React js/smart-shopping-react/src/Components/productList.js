import React, { Component } from 'react'
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import {Typography, AppBar, Card, CardActions, CardContent, CardMedia, CssBaseline, Grid, Link,Toolbar,Container,ButtonGroup,Button} from '@mui/material'

export default class ProductList extends Component {
    constructor(props) {
        super(props)
        this.state = {
            products:[],
        }
    }

    componentDidMount() {
        fetch('http://localhost:8080/product/all')
            .then(res => res.json())
            .then(data => {
                this.setState({
                    products: data
                })
            }
            )
    }
  render() {
    return (
      <>
    <CssBaseline /> 
    <Typography  variant="h4" color="#34A5DD" align="center" noWrap style={{padding:'0px 5px', marginTop: '20px'}}>Product List
    </Typography>
    <TableContainer component={Paper} style={{marginTop:'20px'}}>
      <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
        <TableHead>
          <TableRow>
            <TableCell align="center"  style={{fontWeight:'bold'}}>Product Name</TableCell>
            <TableCell align="center"  style={{fontWeight:'bold'}}>Product Price</TableCell>
            <TableCell align="center"  style={{fontWeight:'bold'}}>Product Quantity</TableCell>
            <TableCell align="center"  style={{fontWeight:'bold'}}>Product Barcode</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
        {this.state.products.map(product => (
            <TableRow key={product.id} sx={{ '&:last-child td, &:last-child th': { border: 0 } }}>
              <TableCell align="center">{product.productName}</TableCell>
              <TableCell align="center">{product.prodcutPrice}</TableCell>
              <TableCell align="center">{product.productQuantity}</TableCell>
              <TableCell align="center">{product.productBarcode}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
        
      </>
    )
  }
}
