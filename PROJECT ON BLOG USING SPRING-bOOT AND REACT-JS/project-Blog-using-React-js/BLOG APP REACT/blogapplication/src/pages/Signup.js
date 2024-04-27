// this is for signup page file
import { CardHeader, Card, Container, CardBody, Form, FormGroup, Label, Input, Button, Row, Col } from "reactstrap";
import Base from "../components/Base";

const Signup = () => {
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
                                        />

                                    </FormGroup>

                                    {/* this is for user email */}
                                    <FormGroup>
                                        <Label for="email">Enter Your Name</Label>
                                        <Input
                                            type="email"
                                            placeholder="Enter email here"
                                            id="email"
                                        />

                                    </FormGroup>

                                    {/* this is for user password */}
                                    <FormGroup>
                                        <Label for="password">Enter Your Password</Label>
                                        <Input
                                            type="password"
                                            placeholder="Enter password here"
                                            id="password"
                                        />

                                    </FormGroup>


                                    {/* this is for user about */}
                                    <FormGroup>
                                        <Label for="about">Enter About</Label>
                                        <Input
                                            type="textarea"
                                            placeholder="Enter about here"
                                            id="about"
                                        />

                                    </FormGroup>

                                    <Container className="text-center">
                                        <Button type="submit" color="dark">Register</Button>
                                        <Button type="reset" color="secondary" className="ms-2">Reset</Button>

                                    </Container>

                                </Form>
                            </CardBody>
                        </Card>
                    </Col>
                </Row>
            </Container>

        </Base>


    )
}

export default Signup;