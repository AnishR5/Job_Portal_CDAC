import axios from 'axios';
import React, { useEffect, useState } from 'react'

export default function PostJob() {
    const [category, setcategory] = useState([]);
    const [location, setlocation] = useState([]);
    const [formData, setFormData] = useState(
        {
            assignedJpId: 0,
            assignedJcId: 0,
            assignedLocationId: 0,
            jobTitle: "string",
            role: "string",
            keySkills: "string",
            salary: 0,
            description: "string",
            vacancies: 0,
            applicationDeadline: ""
          }
    )

    useEffect(()=>{
        axios.get("http://localhost:7070/jobcategory/list")
        .then(response =>{
            setcategory(response.data)
        })
        .catch(error => {
            console.error(error);})
    })

    const handleSubmit = async (e) => {
        e.preventDefault();
    
        try {
          const response = await axios.post("http://localhost:7070/job/insertjob", formData);
          console.log('Registration response:', response.data);
          setSuccessMessage('Job Post successfull!');
          navigate('/job/jobs');
        } catch (error) {
          console.error('Registration error:', error);
          // Handle error
        }
      };

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData((prevData) => ({ ...prevData, [name]: value }));
      };

  return (
    <div> 
        <Container>
      
      <Row className="vh-100 d-flex justify-content-center align-items-center">
        <Col md={8} lg={6} xs={12}>
        <div className="border border-2 border-primary"></div>
          <Card className="shadow px-4">
            <Card.Body>
              <div className="mb-3 mt-md-4">
                <h2 className="fw-bold mb-2 text-center text-uppercase ">Post Job</h2>
                <div className="mb-3">
                  <Form action='/job/insertjob' method='post'> 
                    <Form.Group className="mb-3" controlId="Name">
                      <Form.Label className="text-center">
                        Job Provider Id
                      </Form.Label>
                      <Form.Control  type="text"                          
                          name="assignedJpId"
                          value={formData.assignedJpId}
                          onChange={handleChange} />
                    </Form.Group>

                    <Form.Group
                      className="mb-3"
                      controlId="formBasicPassword"
                    >
                      <Form.Label>Job Category</Form.Label> </Form.Group>
                    <Form.Select aria-label="Default select example"
                          name="assignedJcId"
                          value={formData.assignedJcId}
                          onChange={handleChange}
                          >     
                          {category.map(cat=>(
                            <option key={cat.jcId} value={cat.jcId}>{cat.jcName}</option>
                          ))}                       
                         
                      </Form.Select>

                      <Form.Group
                      className="mb-3"
                      controlId="formBasicPassword"
                    >
                    <Form.Label>Location</Form.Label> </Form.Group>
                    <Form.Select aria-label="Default select example"
                          name="assignedLocationId"
                          value={formData.assignedLocationId}
                          onChange={handleChange}
                          >   
                          {location.map(locate => (
                            <option key={locate.locationId} value={locate.locationId}>{locate.locationName}</option>
                          ))}                         
                          
                      </Form.Select>

                    <Form.Group className="mb-3" controlId="formBasicEmail">
                      <Form.Label className="text-center">
                      Job Title
                      </Form.Label>
                      <Form.Control  type="text"
                         
                          name="jobTitle"
                          value={formData.jobTitle}
                          onChange={handleChange} />
                    </Form.Group>

                    <Form.Group
                      className="mb-3"
                      controlId="formBasicPassword"
                    >
                      <Form.Label>Role</Form.Label>
                      <Form.Control type="text" 
                          name="role"
                          value={formData.role}
                          onChange={handleChange} />
                    </Form.Group>
                    <Form.Group
                      className="mb-3"
                      controlId="formBasicPassword"
                    >
                      <Form.Label>Skills </Form.Label>
                      <Form.Control type="text" placeholder="Java,Python"
                          name="keySkills"
                          value={formData.keySkills}
                          onChange={handleChange}   />
                    </Form.Group>
                    <Form.Group
                      className="mb-3"
                      controlId="formBasicPassword"
                    >
                      <Form.Label>Salary </Form.Label>
                      <Form.Control type="text" 
                          name="salary"
                          value={formData.salary}
                          onChange={handleChange}   />
                    </Form.Group>
                    <Form.Group
                      className="mb-3"
                      controlId="formBasicPassword"
                    >
                      <Form.Label>Description </Form.Label>
                      <Form.Control type="text" 
                          name="description"
                          value={formData.description}
                          onChange={handleChange}   />
                    </Form.Group>
                    <Form.Group
                      className="mb-3"
                      controlId="formBasicPassword"
                    >
                      <Form.Label>vacancies </Form.Label>
                      <Form.Control type="number" 
                          name="vacancies"
                          value={formData.vacancies}
                          onChange={handleChange}   />
                    </Form.Group>
                    <Form.Group
                      className="mb-3"
                      controlId="formBasicPassword"
                    >
                      <Form.Label>Application Deadline </Form.Label>
                      <Form.Control type="date" 
                          name="applicationDeadline"
                          value={formData.applicationDeadline}
                          onChange={handleChange}   />
                    </Form.Group>
                    
                    
                     
                    <Form.Group
                      className="mb-3"
                      controlId="formBasicPassword"
                    >
                      <Form.Label>Skill 3</Form.Label>
                      <Form.Control type="text" placeholder="Skill3" 
                         name="skill3"
                         value={formData.skill3}
                         onChange={handleChange}
                      />
                    </Form.Group>
                    
                    <div className="d-grid">
                      <Button variant="primary" type="submit" onClick={handleSubmit}>
                        Post Job
                      </Button>
                    </div>
                  </Form>
                  
                </div>
              </div>
            </Card.Body>
          </Card>
        </Col>
      </Row>
    </Container>

    </div>
  )
}
