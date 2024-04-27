// this is for signup page file
import { CardHeader, Card, Container, CardBody, Form, FormGroup, Label, Input, Button, Row, Col } from "reactstrap";
import Base from "../components/Base";
import { useEffect, useState } from "react";

import { signup } from "../services/UserService";
import { toast } from 'react-toastify'

const Signup = () => {

    const [data, setData] = useState({
        name: '',
        email: '',
        password: '',
        about: ''
    })

    const [error, setError] = useState({
        error: {},
        isError: false
    })

    // define the useEffect to log the data

    // useEffect(() => {
    //     console.log(data)
    // }, [data])

    // define the handleangeData function to set the data 
    const handleChnageData = (event, filedName) => {

        // console.log(event)
        // console.log(event.target.value)
        setData({ ...data, [filedName]: event.target.value })

    }

    // to reseting the Form
    const resetData = () => {
        console.log("Data has been reset")
        setData({
            name: '',
            email: '',
            password: '',
            about: ''
        })
    }

    // to submit the form

    const submitForm = (event) => {
        event.preventDefault()

        console.log(data)
        // data validation..

        // data send to server by apis
        signup(data).then((response) => {
            console.log(response)
            console.log("success log")
            toast.success("User Register successfull")

            setData({
                name: '',
                email: '',
                password: '',
                about: ''
            })
        }).catch((error) => {
            console.log(error)
            console.log("Error log");
        })

    }

    return (
        <Base>
            <Container>
                <Row className="mt-4">
                    <Col sm={{ size: 6, offset: 3 }}>
                        <Card color="black" outline>
                            <CardHeader>
                                <h1>Fill Inforation to Register</h1>
                            </CardHeader>

                            <CardBody>
                                {/* creating a form  */}
                                <Form>

                                    {/* this is for user name */}
                                    <FormGroup>
                                        <Label for="name">Enter Your Name</Label>
                                        <Input
                                            type="text"
                                            placeholder="Enter name here"
                                            id="name"
                                            onChange={(e) => handleChnageData(e, 'name')}
                                            value={data.name}
                                        />

                                    </FormGroup>

                                    {/* this is for user email */}
                                    <FormGroup>
                                        <Label for="email">Enter Your Name</Label>
                                        <Input
                                            type="email"
                                            placeholder="Enter email here"
                                            id="email"
                                            onChange={(e) => handleChnageData(e, 'email')}
                                            value={data.email}
                                        />

                                    </FormGroup>

                                    {/* this is for user password */}
                                    <FormGroup>
                                        <Label for="password">Enter Your Password</Label>
                                        <Input
                                            type="password"
                                            placeholder="Enter password here"
                                            id="password"
                                            onChange={(e) => handleChnageData(e, 'password')}
                                            value={data.password}
                                        />

                                    </FormGroup>


                                    {/* this is for user about */}
                                    <FormGroup>
                                        <Label for="about">Enter About</Label>
                                        <Input
                                            type="textarea"
                                            placeholder="Enter about here"
                                            id="about"
                                            onChange={(e) => handleChnageData(e, 'about')}
                                            value={data.about}
                                        />

                                    </FormGroup>

                                    <Container className="text-center">
                                        <Button type="submit" color="dark"
                                            onClick={submitForm}>Register</Button>
                                        <Button type="reset" color="secondary" className="ms-2"
                                            onClick={resetData}>Reset</Button>

                                    </Container>

                                </Form>


                            </CardBody>
                        </Card>
                        <Container>
                            <Label>Data:{JSON.stringify(data)} </Label>

                        </Container>
                    </Col>
                </Row>
            </Container>


        </Base>


    )
}

export default Signup;