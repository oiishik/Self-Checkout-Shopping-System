import React, { Component } from 'react'
import {FormControl, InputLabel,FormHelperText,Input,Container,Grid,Typography,Button} from '@mui/material'
export default class AddProduct extends Component {
    //CRATE A CONSTRUCTOR
    constructor(props) {
        super(props)
        this.state = {
            productBarcode: '',
            prodcutPrice: '',
            productName: '',
            productQuantity: ''
        }
    }

    addProduct = (e) => {
        e.preventDefault()
        console.log(this.state)
        fetch('http://localhost:8080/product/add', {
          method: 'POST',
          headers: {'Content-Type': 'application/json'},
          body: JSON.stringify(this.state)
        }).then(() => {
            alert('Product Added Successfully')
            window.location.reload()
        })
    }

  render() {
    return (
      <>
        <Container maxWidth="sm" style={{marginTop:'50px'}}>  
        <Typography variant="h4" color="#34A5DD" noWrap style={{padding:'0px 5px'}}>Add Product
        </Typography>  
        <form>
        <Grid container spacing={2}>
        <Grid item xs={12}  style={{marginTop:'5px'}}>
        <FormControl fullWidth>
        <InputLabel htmlFor="my-input">Product Name</InputLabel >
        <Input id="my-input" aria-describedby="my-helper-text" onChange={(e)=>this.setState({productName: e.target.value })}/>
        <FormHelperText id="my-helper-text">
        Enter Product Name
        </FormHelperText>
        </FormControl>
        </Grid>
        </Grid>
        <Grid container spacing={2}>
        <Grid item xs={12} style={{marginTop:'5px'}}>
        <FormControl fullWidth>
        <InputLabel htmlFor="my-input">Product Price</InputLabel>
        <Input id="my-input" aria-describedby="my-helper-text" type='number'  onChange={(e)=>this.setState({prodcutPrice: e.target.value })} />
        <FormHelperText id="my-helper-text">
        Enter Product Price
        </FormHelperText>
        </FormControl>
        </Grid>
        </Grid>
        <Grid container spacing={2}>
        <Grid item xs={12} style={{marginTop:'5px'}}>
        <FormControl fullWidth>
        <InputLabel htmlFor="my-input">Product Quantity</InputLabel>
        <Input id="my-input" aria-describedby="my-helper-text" type='number'  onChange={(e)=>this.setState({productQuantity: e.target.value })} />
        <FormHelperText id="my-helper-text">
        Enter Product Quantity
        </FormHelperText>
        </FormControl>
        </Grid>
        </Grid>
        <Grid container spacing={2}>
        <Grid item xs={12} style={{marginTop:'5px'}}>
        <FormControl fullWidth>
        <InputLabel htmlFor="my-input">Product Barcode</InputLabel>
        <Input id="my-input" aria-describedby="my-helper-text" type='text'  onChange={(e)=>this.setState({productBarcode: e.target.value })} />
        <FormHelperText id="my-helper-text">
        Enter Product Barcode
        </FormHelperText>
        </FormControl>
        </Grid>
        </Grid>
        <Grid container spacing={2}>
        <Grid item xs={12} style={{marginTop:'5px'}}>  
            <FormControl fullWidth>
            <Button variant="outlined" onClick={this.addProduct}>Add Product</Button>
            </FormControl>
        </Grid>
        </Grid>
        </form>
        </Container>
      </>
    )
  }
}
