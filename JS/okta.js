import React from 'react';
import { LoginCallback } from '@okta/okta-react';



const AppRoutes = () => {
  return (
    <Routes>
      <Route path='path' element={<LoginCallback loadingElement={<Loading />} />} />

    </Routes>
  );
};

export default AppRoutes;