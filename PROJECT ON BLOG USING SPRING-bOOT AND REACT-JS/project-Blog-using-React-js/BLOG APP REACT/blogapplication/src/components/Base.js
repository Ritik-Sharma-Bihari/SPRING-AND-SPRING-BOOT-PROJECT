import CustomeNavbar from "./CustomeNavbar"
const Base = ({ title = "Blog application of VFSTR", children }) => {
    return (
        <div className="container-fluid p-0 m-0">


            {/* this section for dynamic content which is child */}
            <CustomeNavbar />
            {children}

            <h1>this is Footer</h1>
        </div >


    )

}

export default Base