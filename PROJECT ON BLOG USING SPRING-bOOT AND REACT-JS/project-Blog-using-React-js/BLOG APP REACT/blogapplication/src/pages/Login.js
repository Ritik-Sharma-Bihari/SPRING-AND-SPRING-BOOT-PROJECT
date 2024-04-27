// this is for login page file
import { Card, CardBody, CardHeader, Col, Container, Form, FormGroup, Input, Label, Row, Button } from "reactstrap";
import Base from "../components/Base";

const Login = () => {
    return (
        <Base>
            <Container className="mt-5">
                <Row>
                    <Col sm={
                        {
                            size: 6,
                            offset: 3
                        }
                    }>
                        <Card>
                            <CardHeader>
                                <h3>Login Here !!</h3>
                            </CardHeader>

                            <CardBody>
                                <Form>
                                    <FormGroup>
                                        <Label for="email">Enter Your Name</Label>
                                        <Input
                                            type="email"
                                            placeholder="Enter email here"
                                            id="email"
                                        />

                                    </FormGroup>

                                    <FormGroup>
                                        <Label for="password">Enter Password Name</Label>
                                        <Input
                                            type="password"
                                            placeholder="Enter password here"
                                            id="password"
                                        />

                                    </FormGroup>

                                    <Container className="text-center">
                                        <Button type="submit" color="dark">Login</Button>
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

export default Login;