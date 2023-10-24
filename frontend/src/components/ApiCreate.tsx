import * as React from 'react';
import { Create, SimpleForm, TextInput, required, BooleanInput, UrlField } from 'react-admin';

export const ApiCreate = () => (
    <Create>
        <SimpleForm>
            <TextInput source="name" validate={[required()]} />
            <TextInput source="url" multiline={true} validate={[required()]} fullWidth />
            <BooleanInput source='approved' defaultChecked/>
        </SimpleForm>
    </Create>
);