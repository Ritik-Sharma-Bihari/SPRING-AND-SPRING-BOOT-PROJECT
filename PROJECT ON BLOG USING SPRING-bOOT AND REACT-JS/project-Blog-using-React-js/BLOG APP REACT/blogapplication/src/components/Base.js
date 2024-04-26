const Base = ({ title = "Blog application of VFSTR", children }) => {
    return (
        <div className="container-fluid">

            <h1>this is Header</h1>

            {/* this section for dynamic content which is child */}

            {children}

            <h1>this is Footer</h1>
        </div>


    )

}

export default Base